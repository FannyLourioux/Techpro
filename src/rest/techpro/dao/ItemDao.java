package rest.techpro.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.techpro.model.Brand;
import rest.techpro.model.Category;
import rest.techpro.model.Item;


public class ItemDao /*extends GlobalDao<Item> */{
	private Map<UUID, Item> content = new HashMap<>();
	private static ItemDao instance; 
	
	private ItemDao() {
		add(new Item("OptiPlex", Brand.DELL, Category.PC_FIXE, "../assets/img/pcDell.png", "Les ordinateurs de bureau OptiPlex sont desormais dotes d un format restreint et polyvalent et de processeurs Intel 11e generation pour exploiter pleinement votre potentiel.", 2345));
		add(new Item("Zenbook Pro", Brand.ASUS, Category.PC_PORTABLE, "../assets/img/pcAsus.png", "Avec le ZenBook Pro, gardez votre style intact tout en accomplissant vos taches quotidiennes avec calme et efficacite ! ", 1545));
		add(new Item("Macbook Pro", Brand.APPLE, Category.PC_PORTABLE, "../assets/img/Apple.png", "nos ordinateurs portables les plus puissants, avec processeurs rapides, performances graphiques de pointe", 5345));
		add(new Item("Magic Mouse 2", Brand.APPLE, Category.ACCESSOIRE_PC, "../assets/img/AppleMouse.png", "la Magic Mouse 2 n est pas seulement belle, mais egalement entierement rechargeable, ce qui vous evite d utiliser des piles.", 110));
		add(new Item("SANDISK ULTRA FLAIR 3.0 32GO", Brand.SAN_DISK, Category.CLE_USB, "../assets/img/Usb.png", "Passez moins de temps a attendre le transfert de vos fichiers grace a la cle USB 3.0 Ultra Flair de San Disk.", 20));
		add(new Item("Disque SSD Externe SanDisk Extreme Portable 1 To", Brand.SAN_DISK, Category.DISQUE_DUR, "../assets/img/Disque.png", "Disque SSD portable SanDisk ExtremeLe disque SSD portable et robuste SanDisk Extreme offre des transferts de vitesse elevee allant jusqu a 550 Mo/s.", 255));
		add(new Item("Iphone 11", Brand.APPLE, Category.TELEPHONE_PORTABLE, "../assets/img/Iphone.png", "Dans le prolongement des efforts entrepris pour atteindre nos objectifs en matiere de protection de l environnement, l iPhone 11 est livre sans adaptateur secteur.", 1200));
		add(new Item("Air pods", Brand.APPLE, Category.ACCESSOIRE_TELEPHONE, "../assets/img/Ecouteur.png", "Des performances inouies. Dotes de la puce d ecouteurs H1 concue par Apple, les AirPods beneficient d une connexion sans fil plus rapide et plus stable.", 100));
		add(new Item("Coque Fairy Tail", Brand.RHINOSHIELD, Category.ACCESSOIRE_TELEPHONE, "../assets/img/coque.png", "Une coque ultra resistante au couleurs de votre anime prefere", 70));
		add(new Item("Telephone noir panasonic", Brand.PANASONIC, Category.TELEPHONE_FIXE, "../assets/img/panasonicFixe.png", "Si vous etes passione d informatique et d electronique, si vous êtes à la pointe de la technologie et qu aucun detail ne vous echappe, achetez Telephone fixe Panasonic Noir au meilleur prix.", 21.49));
		add(new Item("Telephone alcatel", Brand.ALCATEL, Category.TELEPHONE_FIXE, "../assets/img/fixe.png", "Un telephone fixe sans fil pour vous permettre une liberte de mouvement tout au long de vos appels.", 31.06));
		add(new Item("Cable USB", Brand.LDLC, Category.ACCESSOIRE_STOCKAGE, "../assets/img/cable.jpg", "Ce câble est équipé d'un connecteur micro USB de type B (connecteur biseauté).", 8));
		add(new Item("Adaptateur HDMI/VGA", Brand.LDLC, Category.ACCESSOIRE_STOCKAGE, "../assets/img/adaptateur.jpg", "L adaptateur HDMI / VGA permet la restitution d'un signal HDMI sur un support VGA. Il vous permet de rendre compatible les ecrans VGA avec les cartes graphiques recentes munies uniquement de sorties numeriques.", 19.94));
		add(new Item("Clavier multicolor Razer", Brand.RAZER, Category.ACCESSOIRE_PC, "../assets/img/clavierColor.jpg", "Clavier mecanique compact avec Razer Chroma RGB, alimente par Razer Chroma RGB pour un eclairage personnalisable et une immersion accrue en jeu. Forme compacte pour une configuration epuree ", 169.99));
	}
	
	public static ItemDao getInstance() {
		if(instance == null) {
			instance = new ItemDao();
		}
		return instance;
	}
	
	private Set<Item> mergeSets(Set<Item> s1, Set<Item> s2, Set<Item> s3) {
		Set<Item> tmp = new HashSet<>();
		tmp.addAll(s1);
		tmp.addAll(s2);
		tmp.addAll(s3);
		return tmp;
	}
	
	public Item add(Item product) {
		content.put(product.getId(), product);
		return get(product.getId());
	}
	
	public void delete(UUID id) {
		content.remove(id);
	}
	
	public Item update(Item product) {
		content.replace(product.getId(), product);
		return get(product.getId());
	}
	
	public Item get(UUID id) {
		return content.get(id);
	}
	
	public Set<Item> addAll(List<Item> products) {
		return products.stream().map(product -> add(product)).collect(Collectors.toSet());
	}
	
	public Set<Item> deleteAll(List<UUID> products) {
		products.stream().forEach(product -> delete(product));
		return getAll();
	}
	
	public Set<Item> updateAll(List<Item> products) {
		return products.stream().map(product -> update(product)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAll() {
		return content.values().stream().collect(Collectors.toSet());
	}

	public Set<Item> getPcsFixes() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.PC_FIXE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getPcsPortables() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.PC_PORTABLE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresPc() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_PC)).collect(Collectors.toSet());
	}
	
	public Set<Item> getPcs() {
		return mergeSets(getPcsFixes(), getPcsPortables(), getAccessoiresPc());
	}
	
	public Set<Item> getTelephonesFixes() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.TELEPHONE_FIXE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getTelephonesPortables() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.TELEPHONE_PORTABLE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresTelephone() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_TELEPHONE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getTelephones() {
		return mergeSets(getTelephonesFixes(), getTelephonesPortables(), getAccessoiresTelephone());
	}
	
	public Set<Item> getDisquesDurs() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.DISQUE_DUR)).collect(Collectors.toSet());
	}
	
	public Set<Item> getClesUsb() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.CLE_USB)).collect(Collectors.toSet());
	}
	
	public Set<Item> getAccessoiresStockage() {
		return getAll().stream().filter(item -> item.getCategory().equals(Category.ACCESSOIRE_STOCKAGE)).collect(Collectors.toSet());
	}
	
	public Set<Item> getStockages() {
		return mergeSets(getClesUsb(), getDisquesDurs(), getAccessoiresStockage());
	}
}
