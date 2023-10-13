package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @GetMapping("/Users")
    @GetMapping()
    public List<Usuario> getUsers(){
        return usuarioRepository.findAll();
    }

//    @GetMapping("Users/{username}")
    @GetMapping("/{username}")
    public Usuario getOneUsers(@PathVariable("username") String username){
          return usuarioRepository.findByUsername(username);
    }

//    @DeleteMapping("/Users/{id}")
    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable("id") Integer id){
        usuarioRepository.deleteById(id);
    }

//    @PostMapping("/Users")
    @PostMapping()
    public Usuario postUsers(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
