package pkg1.run;

import pkg1.dto.Enemy;
import pkg1.dto.My;
import pkg1.service.BtService;
import pkg1.view.PokeView;

public class BattleRun1 {
public static void main(String[] args) {
	My m = new My();
	Enemy e = new Enemy();
	BtService bt = new BtService();
	PokeView view = new PokeView();
	
	view.mainMenu();
	
	}
}
