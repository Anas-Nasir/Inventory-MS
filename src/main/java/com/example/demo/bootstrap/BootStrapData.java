package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

/*
        Product HighPerformanceGamingPcs= new Product("HighPerformanceGamingPcs",100.0,15);
        Product StreamingSetup= new Product("StreamingSetup",100.0,15);
        productRepository.save( HighPerformanceGamingPcs);
        productRepository.save(StreamingSetup);
*/


        if (partRepository.count() == 0 && productRepository.count() == 0) {
            Part part1 = new Part("AMD Ryzen 9 5900X Processor", 299.99, 10);
            Part part2 = new Part("NVIDIA RTX 4090 GPU", 499.99, 5);
            Part part3 = new Part("64GB Corsair Vengeance RAM", 99.99, 20);
            Part part4 = new Part("1TB NVMe SSD", 129.99, 15);
            Part part5 = new Part("850W PSU (Power Supply Unit)", 199.99, 8);

            partRepository.save(part1);
            partRepository.save(part2);
            partRepository.save(part3);
            partRepository.save(part4);
            partRepository.save(part5);



            Product product1 = new Product("Elgato Stream Deck", 1499.99, 3);
            Product product2 = new Product("Logitech C920 Webcam", 399.99, 7);
            Product product3 = new Product("Blue Yeti Microphone", 1299.99, 4);
            Product product4 = new Product("Ring Light", 799.99, 6);
            Product product5 = new Product("Green Screen", 999.99, 5);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

        }
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());
        }



    }



