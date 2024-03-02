package com.maximodev.restwithspringboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.maximodev.restwithspringboot.converters.MathConverter;
import com.maximodev.restwithspringboot.exceptions.UnsupportedMathOperationException;
import com.maximodev.restwithspringboot.math.SimpleMath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sum(MathConverter.convertToDouble(numberOne),MathConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.sub(MathConverter.convertToDouble(numberOne),MathConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.mult(MathConverter.convertToDouble(numberOne),MathConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.div(MathConverter.convertToDouble(numberOne),MathConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
    public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception{

        if(!MathConverter.isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.raiz(MathConverter.convertToDouble(numberOne));
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.media(MathConverter.convertToDouble(numberOne),MathConverter.convertToDouble(numberTwo));
    }
}
