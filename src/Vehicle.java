
    public class Vehicle {
        private String id;
        private int speedkmh;
        private String type;
        private boolean isAutonomous;

        public Vehicle(String id, int speedkmh, String type, boolean isAutonomous) {
            this.id = id;
            this.speedkmh = speedkmh;
            this.type = type;
            this.isAutonomous = isAutonomous;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getSpeedkmh() {
            return speedkmh;
        }

        public void setSpeedkmh(int speedkmh) {
            this.speedkmh = speedkmh;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isAutonomous() {
            return isAutonomous;
        }

        public void setAutonomous(boolean autonomous) {
            isAutonomous = autonomous;
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "id='" + id + '\'' +
                    ", speedkmh=" + speedkmh +
                    ", type='" + type + '\'' +
                    ", isAutonomous=" + isAutonomous +
                    '}';
        }
    }

