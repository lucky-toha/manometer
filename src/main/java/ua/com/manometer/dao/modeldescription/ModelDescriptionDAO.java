package ua.com.manometer.dao.modeldescription;
import ua.com.manometer.model.modeldescription.ModelDescription;

import java.util.List;

public interface ModelDescriptionDAO {

	public void updateDescription(ModelDescription modeldescription);

	public List<ModelDescription> listModelDescription();

	public void removeModelDescription(Integer id);

    public  List<ModelDescription> findListByIds(List<Integer> modelIds);
}
