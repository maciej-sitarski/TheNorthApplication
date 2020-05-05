package theNorthApplication.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import theNorthApplication.app.dto.StoreEntityDto;
import theNorthApplication.app.service.StoreService;

@RestController
public class DatabaseStoreRestController {

    private final StoreService storeService;

    @Autowired
    public DatabaseStoreRestController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/rest/api/store/{id}")
    public StoreEntityDto getDatabaseStoreById(@PathVariable("id") String id) {
        StoreEntityDto storeEntityDto = storeService.findStoreById(id);
        return storeEntityDto;
    }

}
