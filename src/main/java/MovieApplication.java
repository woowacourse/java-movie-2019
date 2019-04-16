import domain.Movie;
import domain.MovieRepository;
import domain.PartialApplication;
import domain.PlaySchedule;
import java.util.ArrayList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        ArrayList<PartialApplication> partialApplications = new ArrayList<PartialApplication>();
        while(true){
            PartialApplication pa = new PartialApplication();
            pa.appOfOne();
            partialApplications.add(pa);
            if(!pa.checkIfTooMuchPeople()){
                break;
            }
        }
        // TODO 구현 진행
    }
}
