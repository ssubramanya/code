package routerConfig;

//--> Import routerTableUtils here <--
//import com.legion.kickstart.routerTableUtils;

public class R_Interface {

    public class r_unit {

    }
    public final int MAX_UNIT = 3;

    r_unit r_intfUnit[MAX_UNIT];

    private Error_Info create_sub_intf(byte router_id, byte port_id, byte unit_id) {
        if(unit_id > MAX_UNIT) {
            return Error_Info.MAX_UNIT_ERROR;
        }
        r_intfUnit[unit_id] = new r_unit();
    }
    private byte map_intfId_to_routerId(byte intf_id) {
        switch (intf_id) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            case 6:
            case 7:
                return 3;
            case 8:
            case 9:
                return 4;
            case 10:
            case 11:
                return 5;
            default:
                break;
        }
        return -1;
    }
    public R_Interface(RouterHandler rh, byte router_id, byte intf_id) {
        rh.setConnection(router_id, map_intfId_to_routerId(intf_id), (byte) ((byte)(intf_id % 2)+1));
        for(int i=0;i<6;i++) {
            System.out.print(rh.c_portMap[i]+" ");
        }
    }

    public static void main(String[] args) {
        RouterHandler rh = new RouterHandler();
        R_ErrorInfo re = new R_ErrorInfo();
        R_Interface ri = new R_Interface(rh, (byte) 1, (byte) 5);
        System.out.println();
        R_Interface ri2 = new R_Interface(rh, (byte) 1, (byte) 4);
        System.out.println();
        R_Interface ri3 = new R_Interface(rh, (byte) 2, (byte) 0);
        System.out.println();
        R_Interface ri4 = new R_Interface(rh, (byte) 2, (byte) 1);
        System.out.println();
        System.out.println(rh.isConnected((byte)2, (byte)0, (byte) 1));
        rh.deleteConnection((byte)2, (byte)0, (byte) 1);
        System.out.println(rh.isConnected((byte)2, (byte)0, (byte) 1));

    }
}
