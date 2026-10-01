public class Intersection {
    private String intersectionId;
    private String currentLight;
    private int congestionlevel;

    public Intersection(String intersectionId, int congestionlevel, String currentLight) {
        this.intersectionId = intersectionId;
        this.congestionlevel = congestionlevel;
        this.currentLight = currentLight;
    }

    public String getIntersectionId() {
        return intersectionId;
    }

    public void setIntersectionId(String intersectionId) {
        this.intersectionId = intersectionId;
    }

    public String getCurrentLight() {
        return currentLight;
    }

    public void setCurrentLight(String currentLight) {
        this.currentLight = currentLight;
    }

    public int getCongestionlevel() {
        return congestionlevel;
    }

    public void setCongestionlevel(int congestionlevel) {
        this.congestionlevel = congestionlevel;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "intersectionId='" + intersectionId + '\'' +
                ", currentLight='" + currentLight + '\'' +
                ", congestionlevel=" + congestionlevel +
                '}';
    }
}
