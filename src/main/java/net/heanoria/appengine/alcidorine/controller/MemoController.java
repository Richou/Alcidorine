package net.heanoria.appengine.alcidorine.controller;

import net.heanoria.appengine.alcidorine.entity.Memo;
import net.heanoria.appengine.alcidorine.services.MemoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemoController {

    @Autowired
    private MemoService memoService = null;
    
    public MemoController(){}
    
    @RequestMapping(value = "/memos.do", method = RequestMethod.GET)
    public String doMemosPage(ModelMap model) {
        return "memo/index";
    }
    
    @RequestMapping(value = "/memos/view.do", method = RequestMethod.GET)
    public String doViewMemory(
            @RequestParam(value="id", required = true) Long id,
            ModelMap model) {
        Memo memo = memoService.getMemoById(id);
        model.addAttribute("memory", memo);
        return "memo/view";
    }
    
}
