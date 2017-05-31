package io.fabric8.build.config.image;

import java.io.Serializable;
import java.util.List;

/**
 * @author roland
 * @since 12.10.14
 */
public class WaitConfiguration implements Serializable {

    // Default HTTP Method to use
    public static final String DEFAULT_HTTP_METHOD = "HEAD";

    // Default status codes
    public static final int DEFAULT_MIN_STATUS = 200;
    public static final int DEFAULT_MAX_STATUS = 399;

    public static final String DEFAULT_STATUS_RANGE = String.format("%d..%d", DEFAULT_MIN_STATUS, DEFAULT_MAX_STATUS);


    private int time;

    /**
     * @deprecated Use &lt;http&gt;&lturl&gt;&lt;/url&gt;&lt;/http&gt; instead
     */

    private String url;


    private HttpConfiguration http;


    private ExecConfiguration exec;


    private TcpConfiguration tcp;


    boolean healthy;

    private String log;


    private int shutdown;


    private int kill;


    private Integer exit;

    public WaitConfiguration() {}

    private WaitConfiguration(int time, ExecConfiguration exec, HttpConfiguration http, TcpConfiguration tcp, boolean healthy, String log, int shutdown, int kill, Integer exit) {
        this.time = time;
        this.exec = exec;
        this.http = http;
        this.tcp = tcp;
        this.healthy = healthy;
        this.log = log;
        this.shutdown = shutdown;
        this.kill = kill;
        this.exit = exit;
    }

    public int getTime() {
        return time;
    }

    public String getUrl() {
        return http != null ? http.getUrl() : url;
    }

    public ExecConfiguration getExec() {
        return exec;
    }

    public HttpConfiguration getHttp() {
        return http;
    }

    public TcpConfiguration getTcp() {
        return tcp;
    }

    public boolean getHealthy() {
        return healthy;
    }

    public String getLog() {
        return log;
    }

    public int getShutdown() {
        return shutdown;
    }

    public int getKill() {
        return kill;
    }

    public Integer getExit() {
        return exit;
    }

    // =============================================================================

    public static class Builder {
        private int time = 0,shutdown = 0, kill = 0;
        private String url,log,status;
        boolean healthy;
        private String method;
        private String preStop;
        private String postStart;
        private List<Integer> tcpPorts;
        private String tcpHost;
        private TcpConfigMode tcpMode;
        private Integer exit;

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder healthy(boolean healthy) {
            this.healthy = healthy;
            return this;
        }

        public Builder log(String log) {
            this.log = log;
            return this;
        }

        public Builder shutdown(int shutdown) {
            this.shutdown = shutdown;
            return this;
        }

        public Builder kill(int kill) {
            this.kill = kill;
            return this;
        }

        public Builder exit(Integer exit) {
            this.exit = exit;
            return this;
        }

        public Builder tcpPorts(List<Integer> tcpPorts) {
            this.tcpPorts = tcpPorts;
            return this;
        }

        public Builder tcpHost(String tcpHost) {
            this.tcpHost = tcpHost;
            return this;
        }

        public Builder tcpMode(String tcpMode) {
            if (tcpMode != null) {
                this.tcpMode = TcpConfigMode.valueOf(tcpMode.toLowerCase());
            }
            return this;
        }


        public WaitConfiguration build() {
            return new WaitConfiguration(time,
                                         postStart != null || preStop != null ? new ExecConfiguration(postStart, preStop) : null,
                                         url != null ? new HttpConfiguration(url,method,status) : null,
                                         tcpPorts != null ? new TcpConfiguration(tcpMode, tcpHost, tcpPorts) : null,
                                         healthy,
                                         log,
                                         shutdown,
                                         kill,
                                         exit);
        }

        public Builder preStop(String command) {
            this.preStop = command;
            return this;
        }

        public Builder postStart(String command) {
            this.postStart = command;
            return this;
        }
    }

    public static class ExecConfiguration implements Serializable {

        private String postStart;


        private String preStop;

        public ExecConfiguration() {}

        public ExecConfiguration(String postStart, String preStop) {
            this.postStart = postStart;
            this.preStop = preStop;
        }

        public String getPostStart() {
            return postStart;
        }

        public String getPreStop() {
            return preStop;
        }
    }

    public static class HttpConfiguration implements Serializable {


        private String url;


        private String method = DEFAULT_HTTP_METHOD;


        private String status = DEFAULT_STATUS_RANGE;


        private boolean allowAllHosts;

        public HttpConfiguration() {}

        private HttpConfiguration(String url, String method, String status) {
            this.url = url;
            this.method = method;
            this.status = status;
        }

        public String getUrl() {
            return url;
        }

        public String getMethod() {
            return method;
        }

        public String getStatus() {
            return status;
        }

        public boolean isAllowAllHosts() {
            return allowAllHosts;
        }
    }

    public enum TcpConfigMode {
        // Use mapped ports
        mapped,
        // Use ports directly on the container
        direct,
    }

    public static class TcpConfiguration implements Serializable {

        private String host;


        private List<Integer> ports;


        private TcpConfigMode mode;

        public TcpConfiguration() {}

        private TcpConfiguration(TcpConfigMode mode, String host, List<Integer> ports) {
            this.mode = mode;
            this.host = host;
            this.ports = ports;
        }

        public String getHost() {
            return host;
        }

        public List<Integer> getPorts() {
            return ports;
        }

        public TcpConfigMode getMode() {
            return mode;
        }
    }

}
