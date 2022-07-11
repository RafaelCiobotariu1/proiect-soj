package org.endava.tmd.sojbookrentalproject.controlers;


import lombok.AllArgsConstructor;
import org.endava.tmd.sojbookrentalproject.models.ListaCarti;
import org.endava.tmd.sojbookrentalproject.models.User;
import org.endava.tmd.sojbookrentalproject.repositories.ListaCartiRepository;
import org.endava.tmd.sojbookrentalproject.repositories.UserRepository;
import org.endava.tmd.sojbookrentalproject.services.ListaCartiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lista-carti")
public class ListaCartiController {


    private ListaCartiRepository listaCartiRepository;
    private ListaCartiService listaCartiService;

    @GetMapping
    public List<ListaCarti> list(){
        return listaCartiRepository.findAll();
    }

    @GetMapping({"/{id}"})
    public ListaCarti get(@PathVariable Long id){
        Optional<ListaCarti> optional = listaCartiRepository.findById(id);
        return optional.orElse(null);
    }

    @PostMapping("/{userId}/{bookId}")
    public ListaCarti create(@PathVariable Long userId, @PathVariable Long bookId) {
            return listaCartiService.create(userId,bookId);
    }

    @PutMapping
    public ListaCarti update(@RequestBody final ListaCarti listaCarti){
        return listaCartiRepository.saveAndFlush(listaCarti);
    }


    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable Long id){
        ListaCarti listaCarti =  listaCartiRepository.findById(id).get();
        listaCartiRepository.delete(listaCarti);
    }

    @GetMapping("/available")
    public List<ListaCarti> getAvailable() {
        return listaCartiService.available();
    }

}
