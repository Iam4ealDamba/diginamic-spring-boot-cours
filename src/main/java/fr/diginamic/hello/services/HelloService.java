package fr.diginamic.hello.services;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    /** Permets de saluer l'utilisateur */
    public String salutations() {
        return "Je suis la classe de service et je vous dis Bonjour";
    }
}
