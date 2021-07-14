package by.konovalchik.company.application.components.actions.city;

import by.konovalchik.company.application.components.actions.Action;

public class ShowCitiesNamesAction extends BaseCityAction implements Action {

    @Override
    public void apply() {
       int count = 0;
       System.out.println("Наша география грузоперевозок: ");
       for(int i = 0; i < controller.getCitiesNames().size(); i++){
           System.out.print(controller.getCitiesNames().get(i) + " | ");
           count++;
           if (count == 4){
               System.out.println();
               count = 0;
           }
       }
        System.out.println();
        System.out.println();
    }
}
