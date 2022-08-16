package java01656.m01;

import java.util.ArrayList;
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

    String[] streams;
    int ptr;
    int size;
    public OrderedStream(int n) {
        streams = new String[n + 1];
        ptr = 1;
        size = n + 1;
    }

    public List<String> insert(int idKey, String value) {
        streams[idKey] = value;

        List<String> ret = new ArrayList<>();
        while (ptr < size && streams[ptr] != null) {
            ret.add(streams[ptr]);
            ptr++;
        }

        return ret;
    }
}
