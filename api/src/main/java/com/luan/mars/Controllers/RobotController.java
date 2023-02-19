package com.luan.mars.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luan.mars.Models.RobotPosition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping(value = "/rest")
public class RobotController 
{
    
    private static final String error400Message = "400 Bad Request";
    
    private RobotPosition robotPosition = new RobotPosition();

    @PostMapping("/mars/{message}")
    @ResponseBody
    public String SendMessage(@PathVariable String message)
    {
        
        robotPosition.Reset();
        
        for(int i = 0; i < message.length(); i++)
        {
            var c  = message.charAt(i);
            if(c == 'M')
            {
                if(!robotPosition.Move())
                {
                    return error400Message;
                }
            }
                
            else if (c == 'L' || c == 'R')
                robotPosition.Rotate(c);
            
            else
            {
                return error400Message;
            }
                
            
        }

        return robotPosition.toString();
    }
    
    @PostMapping("/mars/")
    @ResponseBody
    public String WithoutInstructions()
    {
        return "Adicione as instruções ao final deste diretorio";
    }
    
    
    @GetMapping("/mars/{message}")
    @ResponseBody
    public String InvalidMethodMessage()
    {
        return "Metodo invalido. Utilize o metodo POST";
    }
    
}
