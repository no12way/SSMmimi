import com.utils.MD5Util;
import org.junit.Test;

public class TestMD5 {
    @Test
    public void testMD5(){
        String md5 = MD5Util.getMD5("zwf");
        System.out.println(md5);
    }
}