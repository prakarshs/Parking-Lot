package org.LLD.Helper;

import lombok.Data;
import org.LLD.Util.DisplayUtil;
import org.LLD.Util.FindingUtil;
import org.LLD.Util.TicketUtil;

@Data
public class UtilAutowire {
    TicketUtil ticketUtil = new TicketUtil();
    FindingUtil findingUtil = new FindingUtil();
    DisplayUtil displayUtil = new DisplayUtil();

}
