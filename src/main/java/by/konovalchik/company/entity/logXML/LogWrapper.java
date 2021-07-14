package by.konovalchik.company.entity.logXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Logs")
public class LogWrapper {
    private List<Log> logs = new ArrayList<>();

    public LogWrapper(List<Log> logs) {
        this.logs = logs;
    }

    public LogWrapper() {
    }
    @XmlElement(name = "log")
    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
