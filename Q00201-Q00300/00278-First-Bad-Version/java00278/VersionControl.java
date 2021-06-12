package java00278;

/**
 * @Author: alton
 * @Date: Created in 6/13/21 6:06 AM
 * @Description:
 */
public class VersionControl {
    public boolean isBadVersion(int version) {
        if (version >= 1702766719) {
            return true;
        }

        return false;
    }
}
