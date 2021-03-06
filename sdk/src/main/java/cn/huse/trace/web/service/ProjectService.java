package cn.huse.trace.web.service;

import cn.huse.trace.web.common.Utils;
import cn.huse.trace.web.dao.DaoException;
import cn.huse.trace.web.dao.ProjectDao;
import cn.huse.trace.web.entity.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: huanxi
 * @date: 2019/4/28 13:44
 */
@Service
public class ProjectService {
    @Resource
    ProjectDao projectDao;

    private final static String PROJECT_FLAG = "Project_";

    public void addProject(Project project) throws DaoException {
        project.setProjectId(PROJECT_FLAG + project.getUserId() + "_" + Utils.getUUID());
        project.setStatus(Project.STATUS_WAITE);
        projectDao.add(project);
    }

    public Project getProject(String projectId) {
        return projectDao.get(projectId);
    }

    public List<Project> all(int page, int size,int status) {
        return projectDao.all(page, size, status);
    }

    public void update(Project project) throws DaoException {
        projectDao.update(project);
    }

    public List<Project> queryByUserId(String userId) {
        return projectDao.queryByUserId(userId);
    }
}
