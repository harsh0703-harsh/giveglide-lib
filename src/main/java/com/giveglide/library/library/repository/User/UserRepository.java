package com.giveglide.library.library.repository.User;
import com.giveglide.library.library.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {

    UserModel findByEmail(String email);
    UserModel findByEmailAndGuestCheckout(String email, Boolean guestCheckout);
    UserModel findByEmailAndVerificationCode(String email , Integer verificationCode);

}
