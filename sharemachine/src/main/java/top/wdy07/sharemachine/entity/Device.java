package top.wdy07.sharemachine.entity;

public class Device {
    private String did;

    private String cpu;

    private String memsize;

    private Boolean state;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu == null ? null : cpu.trim();
    }

    public String getMemsize() {
        return memsize;
    }

    public void setMemsize(String memsize) {
        this.memsize = memsize == null ? null : memsize.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}