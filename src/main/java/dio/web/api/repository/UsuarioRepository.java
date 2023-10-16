package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.FieldIsEmptyException;
import dio.web.api.handler.PatternException;
import dio.web.api.handler.RequiredFieldException;
import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Repository
    public class UsuarioRepository {
        public Usuario save(Usuario usuario){
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

            if(usuario.getLogin() == null){
                throw new RequiredFieldException("login");
            } else if(usuario.getLogin().isEmpty()){
                throw new FieldIsEmptyException("login");
            }

            if(usuario.getPassword() == null){
                throw new RequiredFieldException("password");
            } else if (!pattern.matcher(usuario.getPassword()).matches()){
                throw new PatternException("O campo password exige pelo menos 8 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula e um dígito.");
            }


            if(usuario.getId()==null){
                System.out.println("SAVE - Recebendo o usuário na camada de repositório");
            } else {
                System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
                System.out.println(usuario);
            }
            return usuario;
        }

        public void deleteById(Integer id){
            System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
            System.out.println(id);
        }
        public List<Usuario> findAll(){
            System.out.println("LIST - Listando os usários do sistema");
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Usuario("gleyson","password"));
            usuarios.add(new Usuario("frank","masterpass"));
            return usuarios;
        }
        public Usuario findById(Integer id){
            System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
            return new Usuario("gleyson","password");
        }
        public Usuario findByUsername(String username){
            System.out.println(String.format("FIND/username - Recebendo o usernamae: %s para localizar um usuário", username));
            return new Usuario("gleyson","password");
        }
    }

