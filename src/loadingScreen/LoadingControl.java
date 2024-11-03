package loadingScreen;

import javax.swing.*;
import ezwallet.Login;

public class LoadingControl {
    private LoadingModel model;
    private LoadingView view;

    public LoadingControl(LoadingModel model, LoadingView view) {
        this.model = model;
        this.view = view;

        model.setLoadingListener(view::setProgress);
        model.startLoading();

        Timer timer = new Timer(3000, e -> {
            view.dispose(); 
            Login lg = new Login(); 
            lg.setVisible(true);

            ((Timer) e.getSource()).stop();
        });
        timer.setRepeats(false); 
        timer.start();
    }

    public void showView() {
        view.setVisible(true);
    }
}
