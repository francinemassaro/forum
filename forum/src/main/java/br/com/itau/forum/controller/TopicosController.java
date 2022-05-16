package br.com.itau.forum.controller;

import br.com.itau.forum.controller.dto.TopicoDto;
import br.com.itau.forum.model.Topico;
import br.com.itau.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);

        } else {
            List<Topico> topicos = topicoRepository.findByCursoNomeIgnoreCase(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    @RequestMapping("/cadastro/topicos")
    public void cadastrar() {

    }
}
