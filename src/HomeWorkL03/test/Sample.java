package HomeWorkL03.test;

public class Sample {

        @Save
        private int aYes;
        private int aNo;
        @Save
        private boolean bYes;
        private boolean bNo;
        @Save
        private String sYes;
        private String sNo;
        @Save
        private char cYes;
        private char cNo;

        public Sample() {
        }

        public Sample(int aYes, int aNo, boolean bYes, boolean bNo, String sYes, String sNo, char cYes, char cNo) {
            this.aYes = aYes;
            this.aNo = aNo;
            this.bYes = bYes;
            this.bNo = bNo;
            this.sYes = sYes;
            this.sNo = sNo;
            this.cYes = cYes;
            this.cNo = cNo;
        }

        public int getaYes() {
            return this.aYes;
        }

        public void setaYes(int aYes) {
            this.aYes = aYes;
        }

        public int getaNo() {
            return this.aNo;
        }

        public void setaNo(int aNo) {
            this.aNo = aNo;
        }

        public boolean isbYes() {
            return this.bYes;
        }

        public void setbYes(boolean bYes) {
            this.bYes = bYes;
        }

        public boolean isbNo() {
            return this.bNo;
        }

        public void setbNo(boolean bNo) {
            this.bNo = bNo;
        }

        public String getsYes() {
            return this.sYes;
        }

        public void setsYes(String sYes) {
            this.sYes = sYes;
        }

        public String getsNo() {
            return this.sNo;
        }

        public void setsNo(String sNo) {
            this.sNo = sNo;
        }

        public char getcYes() {
            return this.cYes;
        }

        public void setcYes(char cYes) {
            this.cYes = cYes;
        }

        public char getcNo() {
            return this.cNo;
        }

        public void setcNo(char cNo) {
            this.cNo = cNo;
        }

        public String toString() {
            return "Sample{aYes=" + this.aYes + ", aNo=" + this.aNo + ", bYes=" + this.bYes + ", bNo=" + this.bNo + ", sYes='" + this.sYes + "', sNo='" + this.sNo + "', cYes=" + this.cYes + ", cNo=" + this.cNo + "}";
        }

}
