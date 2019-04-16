package domain;

        import java.util.HashMap;
        import java.util.Map;

public class TimeAndPeople {
        public Map<PlaySchedule, Integer> map = new HashMap<PlaySchedule, Integer>();

        public TimeAndPeople(PlaySchedule playSchedule, int people) {
                this.map.put(playSchedule, people);
        }
}
