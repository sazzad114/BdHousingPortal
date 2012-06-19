package net.therap.service;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/4/12
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public Object getUserByEmailAndPass(String email, String password);

    public boolean isEmailExists(String email);
}
