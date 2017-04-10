package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hello.StorageFileNotFoundException;
import hello.StorageService;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    
    public FileUploadController( StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

//        model.addAttribute("files", storageService
//                .loadAll()
//                .map(path ->
//                        MvcUriComponentsBuilder
//                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
//                                .build().toString())
//                .collect(Collectors.toList()));

        //return "jsp/test";
        return "jsp/index";
    }
    
    
    
  //home
    @GetMapping("/home")
    public String showHome(Model model) throws IOException {
        return "jsp/Default71a5";
    }
    
   //Venue_Hotel
    @GetMapping("/venue")
    public String showVenue(Model model) throws IOException {
        return "jsp/Default26a6";
    }
    
  //Call
    @GetMapping("/call")
    public String showCall(Model model) throws IOException {
        return "jsp/indexb404";
    }
    
  //submission
    @GetMapping("/sub")
    public String showSubmission(Model model) throws IOException {
        return "jsp/indexd478";
    }
    
    //regis
    @GetMapping("/r")
    public String showRegis(Model model) throws IOException {
        return "jsp/indexa8ef";
    }
    
  //keynote
    @GetMapping("/k")
    public String showKey(Model model) throws IOException {
        return "jsp/index547f";
    }
  //ckeditor
    @GetMapping("/ck")
    public String showCK(Model model) throws IOException {
        return "jsp/CK";
    }
    
    
    

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    @GetMapping("/search")
    public String handleFileSearch(@RequestParam("query") String query, Model model){
    	model.addAttribute("driveAPISearchData", storageService.driveAPISearch(query));    	
    	return "test";
    }
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}