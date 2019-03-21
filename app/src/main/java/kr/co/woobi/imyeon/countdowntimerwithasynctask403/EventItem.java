package kr.co.woobi.imyeon.countdowntimerwithasynctask403;

public class EventItem {
    int time;

    public EventItem(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EventItem{");
        sb.append("time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
