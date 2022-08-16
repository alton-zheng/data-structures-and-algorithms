package java01656.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-16 20:26
 * @Update Date Time: 2022-08-16 20:26
 * @Updated-By: alton_z
 * @Update-Location:
 *
 * 1656. Design an Ordered Stream #428
 *
 */
class OrderedStream {
    String[] streams = new String[1010];
    int ptr;
    public OrderedStream(int n) {
        Arrays.fill(streams, "");
        ptr = 1;
    }
    public List<String> insert(int idKey, String value) {
        streams[idKey] = value;
        List<String> ret = new ArrayList<>();
        while (streams[ptr].length() == 5) {
            ret.add(streams[ptr++]);
        }
        return ret;
    }
}
