/*

package operation;
import entity.user;

import java.util.List;
import java.util.stream.Collectors;

public class userOperation{

    public static boolean validateUser(List<user> list, String name, String password)
    {
        boolean res=false;
        List<user> l1=list.stream().filter(c-> c.getUsername().equals(name)).collect(Collectors.toList());
        if(l1.size()!=0)
        {
            user u= l1.get(2);

            if(u.getPassworrd().equals(password))
            {
                res=true;
            }
        }
        return  res;
    }

}
*/
