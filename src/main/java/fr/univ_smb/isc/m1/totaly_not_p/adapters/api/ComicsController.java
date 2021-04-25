package fr.univ_smb.isc.m1.totaly_not_p.adapters.api;


import fr.univ_smb.isc.m1.totaly_not_p.application.ComicsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence.ComicDTO;
import fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence.ComicSimpleDTO;
import fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence.User;
import fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence.UserDTO;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

    @GetMapping(value="/api/comics")
    public ResponseEntity<List<ComicSimpleDTO>> getAllComics() {
        List<ComicSimpleDTO> comics = comicsService.getAllComics();
        return new ResponseEntity<>(comics, HttpStatus.OK);
    }

    @GetMapping(value="/api/users")
    public ResponseEntity<List<String>> getAllUsers() {
        
        List<String> usernames = new ArrayList<>();
        comicsService.allUsers().forEach(user -> {
            usernames.add(user.getUsername());
        });
        return new ResponseEntity<>(usernames, HttpStatus.OK);
    }

    @GetMapping(value="/api/comic/{id}")
    public ResponseEntity<ComicDTO> getComic(@PathVariable(name = "id") Long id) {
        ComicDTO dto = comicsService.getComic(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value="/api/comic")
    public ResponseEntity<ComicDTO> createComic(@RequestBody ComicDTO comicDto) {
        ComicDTO dto = comicsService.addComic(comicDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping(value="/user/subscribe/{id}")
    public ResponseEntity<Boolean> subscribe(@PathVariable(name = "id") Long id) {
        Boolean success = comicsService.addComicSubscriptionToUser(id);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    
    @GetMapping(value="/user/unsubscribe/{id}")
    public ResponseEntity<Boolean> unsubscribe(@PathVariable(name = "id") Long id) {
        Boolean success = comicsService.removeComicSubscriptionFromUser(id);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
    

    @GetMapping(value="/user/subscriptions")
    public ResponseEntity<List<ComicSimpleDTO>> getSubscriptions() {
        List<ComicSimpleDTO> comics = comicsService.getUserSubscriptions();
        return new ResponseEntity<>(comics, HttpStatus.OK);
    }

    @PutMapping(value="/api/comic/{id}")
    public ResponseEntity<ComicDTO> updateComic(@PathVariable(name = "id") Long id, @RequestBody ComicDTO comicDTO) {
        ComicDTO dto = comicsService.updateComic(id, comicDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/api/comic/{id}")
    public ResponseEntity<String> deleteComic(@PathVariable(name = "id") Long id) {
        String msg = comicsService.deleteComic(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping(value = "/register/confirmation")
    public ModelAndView registerUser(@ModelAttribute("user") UserDTO userDTO,
    HttpServletRequest request,
    Errors errors) {
      
        comicsService.registerUser(userDTO);
        return new ModelAndView("index", "user", userDTO);
    }
}
