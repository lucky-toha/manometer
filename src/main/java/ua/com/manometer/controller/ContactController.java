package ua.com.manometer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.manometer.model.Contact;
import ua.com.manometer.model.Profession;
import ua.com.manometer.service.ContactService;
import ua.com.manometer.service.ProfessionService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ProfessionService professionService;

    @RequestMapping("/")
    public String populateContacts(Map<String, Object> map, @RequestParam(value = "customer", required = false) String customer) {
        System.out.println("customerId = " + customer);

        List<Contact> contacts;
        if (customer==null){
            contacts  = contactService.listContact();
        }       else {
            contacts  = contactService.listContact(customer);
        }
        map.put("listContact", contacts);
        map.put("customer", customer);
        return "contacts";
    }

    @RequestMapping("/edit")
    public String setupForm(@RequestParam(value = "id", required = false) Integer id, ModelMap model) {

        model.put("professions", professionService.listProfession());

        if (id == null) {
            final Contact contact = new Contact();
            final Profession profession = new Profession();
            profession.setId(0);
            contact.setProfession(profession);
            model.put("contact", contact);
        } else {
            model.put("contact", contactService.getContact(id));
        }
        return "editContact";
    }


//    @RequestMapping("/add")
//    public String editContacts(@ModelAttribute("user") User user, Map<String, Object> map) {
//        System.out.println(user);
//        userService.addUser(user);
//
//        map.put("userList", userService.listUser());
//        return "redirect:/users/";
//    }

    @RequestMapping("/add")
    public String processSubmit(@ModelAttribute("contact") Contact contact) {
        if (contact.getProfession().getId() == null) {
            System.out.println("profession error");
            contact.setProfession(null);
        }

        contact.setOldRecord(null);
        contactService.addContact(contact);
        return "redirect:/contacts/";
    }
}
