package routerTableUtils;

public class v4_address {
    long c_v4Addr;
    byte c_mask;

    public String ipToString(long v4_addr) {
        StringBuilder ip =  new StringBuilder();
        for(int i=0; i<4; i++) {
            ip.insert(0, Long.toString(v4_addr&0xff));
            if(i < 3) {
                ip.insert(0,'.');
            }
            v4_addr = v4_addr >> 8;
        }
        return ip.toString();
    }
}
