package kr.co.woobi.imyeon.countdowntimerwithasynctask403;

public class EventCancel {

    boolean flag=false;

    public EventCancel(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
