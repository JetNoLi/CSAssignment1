public class Key{
        private int stage;
        private int day;
        private int time;
        private String key;

        public Key(int stage, int day, int time, String key){
                this.stage = stage;
                this.day = day;
                this.time = time;
                this.key = key;
                }

        public String getKey(){
                return key;
                }

        public int getStage(){
                return stage;
                }

        public int getDay(){
                return day;
                }

        public int getTime(){
                return time;
                }

        }

