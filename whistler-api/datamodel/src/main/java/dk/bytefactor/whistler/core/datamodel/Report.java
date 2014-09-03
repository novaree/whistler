package dk.bytefactor.whistler.core.datamodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by casper on 31/08/14.
 */
public class Report {

    public enum ReportType {
        LOST, FOUND;
    }

    private String reportId;
    private ReportType reportType;
    private GeoLocation location;
    private Date created;
    private InventoryItem inventoryItem;
    private BigDecimal bounty;
    private User resolvedBy;
    private boolean resolved;
    private Date resolvedDate;
}
