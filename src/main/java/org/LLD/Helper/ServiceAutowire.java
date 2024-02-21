package org.LLD.Helper;

import lombok.Data;
import org.LLD.Services.Display.DisplayService;
import org.LLD.Services.Display.DisplayServiceIMPL;
import org.LLD.Services.Finding.FindingService;
import org.LLD.Services.Finding.FindingServiceIMPL;
@Data
public class ServiceAutowire {
    DisplayService displayService = new DisplayServiceIMPL();
    FindingService findingService = new FindingServiceIMPL();
}
