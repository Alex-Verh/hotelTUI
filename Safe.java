package ss.hotel;

public class Safe {

    private String safe;
    private String info2;

    Safe() {
        safe = "deactived";
        info2 = "closed";
    }

    public void activate() {
        this.safe = "activated";
    }

    public void deactivate() {
        this.safe = "deactived";
        this.info2 = "closed";
    }

    public void open() {
        if ("activated".equals(this.safe)) {
            this.info2 = "opened";
        }
    }

    public void close() {
        this.info2 = "closed";
    }

    public boolean isActive() {
        return "activated".equals(this.safe);
    }

    public boolean isOpen() {
        return "opened".equals(this.info2);
    }
}
