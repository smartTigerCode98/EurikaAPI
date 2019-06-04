package service;


import com.google.gson.Gson;
import entity.UsersEntity;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import security.JwtConfig;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private UsersEntity getUserById(int id){
        return userRepository.findById(id);
    }

    public UsersEntity getUserByToken(String token){
        Claims claims = JwtConfig.decodeJWT(token);
        String json = claims.getSubject();
        json = json.substring(json.indexOf(':')+1, json.length()-1);
        UsersEntity usersEntity = new Gson().fromJson(json, UsersEntity.class);
        return getUserById(usersEntity.getId());
    }
}
