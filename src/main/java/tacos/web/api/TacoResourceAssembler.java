package tacos.web.api;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tacos.entity.Taco;

public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return null;
    }
}
