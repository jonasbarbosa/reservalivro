package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Newusermob {

public static final int TIMEOUT = 300;

/**
 *
 * @param senha
 * @param nome
 * @param login
 * @param e_mail
 * @return Var
 */
// newusermob
public static synchronized Var newusermob(Var senha, Var nome, Var login, Var e_mail) throws Exception {
 return new Callable<Var>() {

   private Var ex = Var.VAR_NULL;
   private Var IdUser = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),Var.valueOf("password",senha),Var.valueOf("name",nome),Var.valueOf("login",login),Var.valueOf("email",e_mail));
     } catch (Exception ex_exception) {
          ex = Var.valueOf(ex_exception);
         cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), Var.valueOf(Var.valueOf("Erro: ").toString() + ex.toString()));
        System.out.println(ex.getObjectAsString());
     } finally {
         IdUser = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u.id from User u where u.login = :login"),Var.valueOf("login",login));
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),Var.valueOf("id",Var.valueOf("Aluno")),Var.valueOf("user",cronapi.list.Operations.getFirst(IdUser)));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), Var.valueOf("batenu"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/app/login"));
        System.out.println(Var.valueOf("abc").getObjectAsString());
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

