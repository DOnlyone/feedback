package edu.bnuz.fb.entity;

public class WfDef {
    private Long nodeId;

    private Long nextNode;

    private String processRole;
    
    private String nodeDesc;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getNextNode() {
        return nextNode;
    }

    public void setNextNode(Long nextNode) {
        this.nextNode = nextNode;
    }

	public String getProcessRole() {
		return processRole;
	}

	public void setProcessRole(String processRole) {
		this.processRole = processRole;
	}

	public String getNodeDesc() {
		return nodeDesc;
	}

	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc;
	}
	
	


}