package cn.tniub.androidqqhook.bean;

public class ToServiceMsg {

    private int appId;
    private int appSeq;
    private String serviceCmd;
    private String serviceName;
    private int ssoSeq;
    private String uin;
    private String wupBuffer;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getAppSeq() {
        return appSeq;
    }

    public void setAppSeq(int appSeq) {
        this.appSeq = appSeq;
    }

    public String getServiceCmd() {
        return serviceCmd;
    }

    public void setServiceCmd(String serviceCmd) {
        this.serviceCmd = serviceCmd;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getSsoSeq() {
        return ssoSeq;
    }

    public void setSsoSeq(int ssoSeq) {
        this.ssoSeq = ssoSeq;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getWupBuffer() {
        return wupBuffer;
    }

    public void setWupBuffer(String wupBuffer) {
        this.wupBuffer = wupBuffer;
    }
}
