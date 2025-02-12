package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
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


            InhousePart AMD = new InhousePart();
            AMD.setName("AMD Ryzen 9 5900X Processor");
            AMD.setPrice(299.99);
            AMD.setInv(10);

            InhousePart Nvidia = new InhousePart();
            Nvidia.setName("NVIDIA RTX 4090 GPU");
            Nvidia.setPrice(499.99);
            Nvidia.setInv(5);

            InhousePart Corsair = new InhousePart();
            Corsair.setName("64GB Corsair Vengeance RAM");
            Corsair.setPrice(499.44);
            Corsair.setInv(10);

            InhousePart NVMe = new InhousePart();
            NVMe.setName("1TB NVMe SSD");
            NVMe.setPrice(129.99);
            NVMe.setInv(15);

            InhousePart PSU = new InhousePart();
            PSU.setName("850W PSU (Power Supply Unit");
            PSU.setPrice(199);
            PSU.setInv(10);

            partRepository.save(AMD);
            partRepository.save(Nvidia);
            partRepository.save(Corsair);
            partRepository.save(NVMe);
            partRepository.save(PSU);


            Product ElgatoStreamDeck = new Product("Elgato Stream Deck", 1499.99, 3);
            Product LogitechC920Webcam = new Product("Logitech C920 Webcam", 399.99, 7);
            Product BlueYetiMicrophone = new Product("Blue Yeti Microphone", 1299.99, 4);
            Product RingLight = new Product("Ring Light", 799.99, 6);
            Product GreenScreen = new Product("Green Screen", 999.99, 5);

            productRepository.save(ElgatoStreamDeck);
            productRepository.save(LogitechC920Webcam);
            productRepository.save(BlueYetiMicrophone);
            productRepository.save(RingLight);
            productRepository.save(GreenScreen);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}





