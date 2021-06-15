package routerConfig;

public class R_ErrorInfo {
    public R_ErrorInfo(){

    };

    String ErrorNumbertoInfo(Error_Info errno) {
        switch (errno) {
            case MAX_UNIT_ERROR:
                //push this onto the screen;
                return "Maximum allowed logical units to configure is 4";

        }
        return "";
    }

}
