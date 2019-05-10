package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public")
public class NovoUsuario {

public static final int TIMEOUT = 300;

/**
 *
 * @param email
 * @param nome
 * @param login
 * @param senha
 * @return Var
 */
// novoUsuario
public static Var NewUser(Var email, Var nome, Var login, Var senha) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("password",senha),Var.valueOf("name",nome),Var.valueOf("login",login),Var.valueOf("email",email));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/login"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

