package ro.master.pricingengine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import ro.master.pricingengine.beans.MatrixRow;
import ro.master.pricingengine.beans.PriceCell;
import ro.master.pricingengine.beans.SimpleRestResponse;
import ro.master.pricingengine.services.PricesetService;

import java.util.List;

@RestController
public class PricesetRestController {

    @Autowired
    PricesetService pricesetService;

    @GetMapping(path = "/rest/pricesets/{pricesetId}/rows")
    public List<MatrixRow> getMatrixPriceRows(@PathVariable("pricesetId") Long pricesetId) {
        Assert.isTrue(null != pricesetId, "Trying to fetch rows for null pricesetId");
        return pricesetService.getMatrixRows(pricesetId);
    }

    @PostMapping(path = "/rest/pricesets/{pricesetId}/cells/save")
    public SimpleRestResponse saveGivenCells(@PathVariable("pricesetId") Long pricesetId, @RequestBody List<PriceCell> priceCells) {
        pricesetService.savePriceCells(priceCells);
        return new SimpleRestResponse();
    }
}
