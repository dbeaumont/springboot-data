export interface DataModel {
    id?: number;
    timestamp: Date;
    content: string;
    status: 'PENDING' | 'COMPLETED';
  }
