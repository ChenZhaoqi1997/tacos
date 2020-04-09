package tacos.web.api;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.data.TacoRepository;
import tacos.entity.Taco;

import java.util.List;

@RepositoryRestController
public class RecentTacosController {
    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/hal+json")
    public ResponseEntity<Resources<TacoResource>> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
        Resources<TacoResource> recentResources = new Resources<>(tacoResources);
        recentResources.add(
                ControllerLinkBuilder.linkTo(RecentTacosController.class)
                .slash("recent")
                .withRel("recents"));
        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }
}
